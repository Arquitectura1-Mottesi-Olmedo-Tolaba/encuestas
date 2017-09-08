package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.UserCredential;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.UserData;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.UserProfile;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.UserProfileRepository;


@Service
@Transactional
public class UserProfileService extends GenericService<UserProfile> {
	
	@Autowired
	private UserProfileRepository repository;
	
	public UserProfileService() { }

	public UserProfileRepository getRepository() {
		return repository;
	}

	public void setRepository(UserProfileRepository repository) {
		this.repository = repository;
	}


	@Transactional
	public UserProfile createUserProfile(UserCredential userCredential) {
		UserData userData = new UserData();
		UserProfile userProfile = new UserProfile(userCredential, userData);
		return super.save(userProfile);
	}

	public UserProfile findByUserId(Long id) {
		UserProfile fetchedProfile =  repository.findByUserId(id);
		if (fetchedProfile == null) {
			throw new RuntimeException("No matching profile could be found for user");
		} else {
			return fetchedProfile;
		}
	}

}
