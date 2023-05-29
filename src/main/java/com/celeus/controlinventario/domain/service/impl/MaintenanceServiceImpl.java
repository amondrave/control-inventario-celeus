package com.celeus.controlinventario.domain.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.celeus.controlinventario.domain.connector.MaintenanceConnector;
import com.celeus.controlinventario.domain.dto.ActiveDto;
import com.celeus.controlinventario.domain.dto.EvidenceDto;
import com.celeus.controlinventario.domain.dto.MaintenanceDto;
import com.celeus.controlinventario.domain.dto.MaintenanceTypeDto;
import com.celeus.controlinventario.domain.dto.ObservationDto;
import com.celeus.controlinventario.domain.dto.UserDto;
import com.celeus.controlinventario.domain.service.ActiveService;
import com.celeus.controlinventario.domain.service.EvidenceService;
import com.celeus.controlinventario.domain.service.MaintenanceService;
import com.celeus.controlinventario.domain.service.MaintenanceTypeService;
import com.celeus.controlinventario.domain.service.ObservationService;
import com.celeus.controlinventario.domain.service.UserService;
import com.celeus.controlinventario.domain.utils.FileUploadUtil;
import com.celeus.controlinventario.persistence.entity.Maintenance;
import com.celeus.controlinventario.persistence.mapper.MaintenanceMapper;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {
	
	private final MaintenanceConnector maintenanceConnector;
	
	private final MaintenanceMapper maintenanceMapper;
	
	private final ObservationService observationService;
	
	private final EvidenceService evidenceService;
	
	private final ActiveService activeService;
	
	private final UserService userService;
	
	private final Environment environment;
	
	private final MaintenanceTypeService maintenanceTypeService;
	
	private static final String URL_DIRECTORY = "image.upload.directoy.evidence";
	

	public MaintenanceServiceImpl(MaintenanceConnector maintenanceConnector, MaintenanceMapper maintenanceMapper,
			ObservationService observationService, EvidenceService evidenceService, ActiveService activeService,
			UserService userService, Environment environment,MaintenanceTypeService maintenanceTypeService ) {
		super();
		this.maintenanceConnector = maintenanceConnector;
		this.maintenanceMapper = maintenanceMapper;
		this.observationService = observationService;
		this.evidenceService = evidenceService;
		this.activeService = activeService;
		this.userService = userService;
		this.environment = environment;
		this.maintenanceTypeService = maintenanceTypeService;
	}

	@Override
	public MaintenanceDto create(MaintenanceDto maintenanceDto, MultipartFile[] images) throws IOException {
		// TODO Auto-generated method stub
		UserDto userDto = userService.getUserById(maintenanceDto.getUserDto().getId());
		ActiveDto activeDto = activeService.getActiveById(maintenanceDto.getActiveDto().getId());
		MaintenanceTypeDto maintenanceTypeDto = maintenanceTypeService.getMaintenanceType(maintenanceDto.getMaintenanceTypeDto().getId());
		Maintenance maintenance = maintenanceMapper.dtoToEntity(maintenanceDto);
		MaintenanceDto maintenanceResponse = maintenanceMapper.entityToDto(maintenanceConnector.createMaintenance(maintenance));
		maintenanceResponse.setListObservation(maintenanceDto.getListObservation());
		maintenanceDto.setListEvidence(setUpEvidences(maintenanceResponse, images));
		setUpObservation(maintenanceResponse);
		return maintenanceResponse;
	}
	
	private void setUpObservation(MaintenanceDto maintenanceDto) {
		if(maintenanceDto.getListObservation() != null && !maintenanceDto.getListObservation().isEmpty()) {
			maintenanceDto.getListObservation().forEach(observation -> {
				observation.setMaintenanceDto(maintenanceDto);
				observation.setUserDto(maintenanceDto.getUserDto());
				observation = observationService.createObservatio(observation);
			});
		}
	}
	
	private List<EvidenceDto> setUpEvidences(MaintenanceDto maintenanceDto, MultipartFile[] images) throws IOException{
		List<EvidenceDto> evidenceDto = new ArrayList<>();
		if(images!= null && images.length > 0) {
			for (MultipartFile file : images) {
				String fileName = file.getOriginalFilename();
				String folder = environment.getProperty(URL_DIRECTORY);
				try {
					assert fileName != null;
					FileUploadUtil.saveFile(folder, fileName, file);
					EvidenceDto eDto = new EvidenceDto();
					eDto.setEvidenceUrl(folder+fileName);
					eDto.setMaintenanceDto(maintenanceDto);
					eDto.setUserDto(maintenanceDto.getUserDto());
					eDto = evidenceService.createEvidence(eDto);
					evidenceDto.add(eDto);
				} catch (IOException e) {
					throw new IOException("No se pueden guardar las imagenes en el servidor");
				}
			}
		}
		return evidenceDto;
	}
	

	@Override
	public MaintenanceDto getMaintenanceById(Long id) {
		// TODO Auto-generated method stub
		MaintenanceDto maintenanceDto = maintenanceMapper.entityToDto(maintenanceConnector.getMaintenanceById(id));
		maintenanceDto.setListEvidence(evidenceService.getEvidenceDtoByMaintenance(id));
		maintenanceDto.setListObservation(observationService.getObservationByIdMaintenance(id));
		return maintenanceDto;
	}

	@Override
	public List<MaintenanceDto> getAllMaintenanceByActive(Long idActive) {
		// TODO Auto-generated method stub
		List<Maintenance> listMaintenance = maintenanceConnector.getAllMaintenanceByIdActive(idActive);
		if(!listMaintenance.isEmpty())
			return mapperList(listMaintenance);
		return null;
	}
	
	private List<MaintenanceDto> mapperList(List<Maintenance> list){
		return list.stream().map(m ->{
			MaintenanceDto maintenanceDto = maintenanceMapper.entityToDto(m);
			return maintenanceDto;
		})
		.collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		
		
	}

}
