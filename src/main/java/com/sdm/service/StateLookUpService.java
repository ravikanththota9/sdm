package com.sdm.service;

import com.sdm.model.User;
import com.sdm.dao.StateLookUpDao;
import com.sdm.dto.StateLookupDTO;
import com.sdm.model.StateLookupModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StateLookUpService {

	@Autowired
	StateLookUpDao stateLookUpDao;

	@Autowired
	User user;

	public void insertStateData(List<StateLookupDTO> stateLookupDTOList) {
		List<StateLookupModel> stateLookupModelList = new ArrayList<StateLookupModel>();
		stateLookupDTOList.forEach(stateLookupDTO -> {
			StateLookupModel stateLookupModel = new StateLookupModel();
			BeanUtils.copyProperties(stateLookupDTO, stateLookupModel);
			stateLookupModel.setCreatedUserId(user.getUserId());
			stateLookupModel.setLastUpdatedUserId(user.getUserId());
			stateLookupModel.setLastUpdatedDate(new java.sql.Date(new Date().getTime()));
			stateLookupModel.setIsDeleted(new Integer(0));
			stateLookupModelList.add(stateLookupModel);

		});
		stateLookUpDao.insertStateData(stateLookupModelList);
	}

	public void updateStateData(List<StateLookupDTO> stateLookupDTOList) {
		List<StateLookupModel> stateLookupModelList = new ArrayList<StateLookupModel>();
		stateLookupDTOList.forEach(stateLookupDTO -> {
			StateLookupModel stateLookupModel = new StateLookupModel();
			BeanUtils.copyProperties(stateLookupDTO, stateLookupModel);
			stateLookupModel.setLastUpdatedUserId(user.getUserId());
			stateLookupModel.setLastUpdatedDate(new java.sql.Date(new Date().getTime()));
			stateLookupModelList.add(stateLookupModel);

		});
		stateLookUpDao.updateStateData(stateLookupModelList);

	}

	public List<StateLookupModel> fetchStateByIdData(Integer countryLookupId) {
		return stateLookUpDao.fetchStateByCidData(countryLookupId);
	}

	public List<StateLookupModel> fetchAllStateData() {
		return stateLookUpDao.fetchAllStateData();
	}

	public void deleteStateData(Integer id) {
		stateLookUpDao.deleteStateData(id);
	}

}
