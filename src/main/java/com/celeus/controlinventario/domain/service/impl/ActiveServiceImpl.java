package com.celeus.controlinventario.domain.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.celeus.controlinventario.domain.connector.ActiveConnector;
import com.celeus.controlinventario.domain.dto.ActiveDto;
import com.celeus.controlinventario.domain.dto.ActiveTypeDto;
import com.celeus.controlinventario.domain.dto.UserDto;
import com.celeus.controlinventario.domain.service.ActiveService;
import com.celeus.controlinventario.domain.service.ActiveTypeService;
import com.celeus.controlinventario.domain.service.UserService;
import com.celeus.controlinventario.domain.utils.FileUploadUtil;
import com.celeus.controlinventario.domain.utils.Utils;
import com.celeus.controlinventario.persistence.entity.Active;
import com.celeus.controlinventario.persistence.mapper.ActiveMapper;



@Service
public class ActiveServiceImpl implements ActiveService {
	
	private final ActiveConnector activeConnector;
	
	private final ActiveMapper activeMapper;
	
	private final ActiveTypeService activeTypeService;
	
	private final UserService userService;
	
	private final Environment environment;
	
	private static final String IMAGE_FOLDER_URL = "image.upload.directory";
	

	public ActiveServiceImpl(ActiveConnector activeConnector, ActiveMapper activeMapper, ActiveTypeService activeTypeService ,
		UserService userService	,Environment environment) {
		super();
		this.activeConnector = activeConnector;
		this.activeMapper = activeMapper;
		this.activeTypeService = activeTypeService;
		this.userService = userService;
		this.environment = environment;
	}

	@Override
	public List<ActiveDto> getAllActivesEnabled() {
		// TODO Auto-generated method stub
		List<ActiveDto> activeDtos = this.mapperActiveList( activeConnector.getAllActivesEnabled());
		return activeDtos;
	}
	
	private List<ActiveDto> mapperActiveList(List<Active> activeList){
		return activeList.stream()
				.map(activo -> {
					ActiveDto activeDto = activeMapper.entityToDto(activo);
					return activeDto;
				})
				.collect(Collectors.toList());
	}

	@Override
	public ActiveDto saveActive(ActiveDto activeDto, MultipartFile image) throws IOException {
		// TODO Auto-generated method stub
		
		setUpImage(activeDto,image);
		ActiveTypeDto activeTypeDto = activeTypeService.getActiveTypeById(activeDto.getActiveTypeDto().getId());
		UserDto userDto = userService.getUserById(activeDto.getUserDto().getId());
		activeDto.setActiveTypeDto(activeTypeDto);
		activeDto.setUserDto(userDto);
		activeDto.setEnabled(true);
		return activeMapper.entityToDto(activeConnector.createActive(activeDto));
	}
	
	private void setUpImage(ActiveDto activeDto,  MultipartFile image) throws IOException {
		String fileName = Utils.cleanPath(image.getOriginalFilename());
		String folder = environment.getProperty(IMAGE_FOLDER_URL);
		FileUploadUtil.saveFile(folder, fileName, image);
		// Buscar ActiveType para setearlo en el dto
		
		activeDto.setImage(folder+fileName);
	} 
	

	@Override
	public ActiveDto updateActive(ActiveDto activeDto, MultipartFile image) throws IOException {
		// TODO Auto-generated method stub
		// Buscar ActiveType para setearlo en el dto
		ActiveDto acDto = getActiveById(activeDto.getId());
		FileUploadUtil.deleteImage(acDto.getImage());
		setUpImage(activeDto,image);
		ActiveTypeDto activeTypeDto = activeTypeService.getActiveTypeById(activeDto.getActiveTypeDto().getId());
		UserDto userDto = userService.getUserById(activeDto.getUserDto().getId());
		activeDto.setActiveTypeDto(activeTypeDto);
		activeDto.setUserDto(userDto);
		activeDto.setEnabled(true);
		return activeMapper.entityToDto(activeConnector.updateActive(activeDto));
	}

	@Override
	public ActiveDto getActiveById(Long id) {
		// TODO Auto-generated method stub
		ActiveDto avActiveDto = activeMapper.entityToDto(activeConnector.getActiveById(id));
		setImageBaseForActiveDto(avActiveDto);
		return avActiveDto;
	}

	@Override
	public ActiveDto getActiveByCode(String code) {
		// TODO Auto-generated method stub
		ActiveDto avActiveDto = activeMapper.entityToDto(activeConnector.getActiveByCode(code));
		setImageBaseForActiveDto(avActiveDto);
		return avActiveDto;
	}
	
	private void setImageBaseForActiveDto(ActiveDto activeDto) {
		if(StringUtils.isNoneBlank(activeDto.getImage()))
			activeDto.setImageBase(this.getBaseImage(activeDto.getImage()));
	}
	
	private String getBaseImage(String fileImage) {
		try {
            File file = new File(fileImage);
            byte[] fileContent = FileUploadUtil.readFileToByteArray(file);
            String base64String = Base64.getEncoder().encodeToString(fileContent);
            return base64String;
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
	}

	@Override
	public void enabledActive(Long id) {
		// TODO Auto-generated method stub
		activeConnector.enabledActive(id);		
	}

}
