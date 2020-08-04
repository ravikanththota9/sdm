package com.sdm.service;

import com.sdm.model.User;
import com.sdm.dao.CountryLookUpDao;
import com.sdm.dto.CountryLookupDTO;
import com.sdm.model.CountryLookupModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CountryLookUpService {

    @Autowired
    CountryLookUpDao countryLookUpDao;

    @Autowired
    User user;

    public void insertCountryData(List<CountryLookupDTO> countryLookupDTOList) {
        List<CountryLookupModel> countryLookupModelList = new ArrayList<CountryLookupModel>();
        countryLookupDTOList.forEach(countryLookupDTO -> {
            CountryLookupModel countryLookupModel = new CountryLookupModel();
            BeanUtils.copyProperties(countryLookupDTO, countryLookupModel);
            countryLookupModel.setCreatedUserId(user.getUserId());
            countryLookupModel.setLastUpdatedUserId(user.getUserId());
            countryLookupModel.setLastUpdatedDate(new java.sql.Date(new Date().getTime()));
            countryLookupModel.setIsDeleted(new Integer(0));
            countryLookupModelList.add(countryLookupModel);

        });
        countryLookUpDao.insertCountryData(countryLookupModelList);
    }

    public void updateCountryData(List<CountryLookupDTO> countryLookupDTOList) {
        List<CountryLookupModel> countryLookupModelList = new ArrayList<CountryLookupModel>();
        countryLookupDTOList.forEach(countryLookupDTO -> {
            CountryLookupModel countryLookupModel = new CountryLookupModel();
            BeanUtils.copyProperties(countryLookupDTO, countryLookupModel);
            countryLookupModel.setLastUpdatedUserId(user.getUserId());
            countryLookupModel.setLastUpdatedDate(new java.sql.Date(new Date().getTime()));
            countryLookupModelList.add(countryLookupModel);

        });
        countryLookUpDao.updateCountryData(countryLookupModelList);
    }

    public List<CountryLookupModel> fetchAllCountryData() {
        return countryLookUpDao.fetchAllCountryData();
    }

    public List<CountryLookupModel> fetchCountryDataById(Integer id) {
        return countryLookUpDao.fetchCountryDataById(id);
    }

    public void deleteCountryData(Integer id) {
        countryLookUpDao.deleteCountryData(id);
    }
}
