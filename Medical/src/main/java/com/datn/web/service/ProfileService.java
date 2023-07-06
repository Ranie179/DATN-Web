package com.datn.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datn.web.bean.Profile;
import com.datn.web.repository.ProfileRepository;

@Service
public class ProfileService {
	@Autowired
	private ProfileRepository profileRepository;

	public List<Profile> showProfile(String email) {
		return profileRepository.showProfile(email);
	}

	public void editProfile(String name, String phone, String birthDay, String blood, String gender, String commune,
			String district, String province, String email) {
		profileRepository.editProfile(name, phone, birthDay, blood, gender, commune, district, province, email);
		
	}

}
