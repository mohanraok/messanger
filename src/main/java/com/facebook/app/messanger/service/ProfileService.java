package com.facebook.app.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.facebook.app.messanger.database.DatabaseClass;
import com.facebook.app.messanger.model.Profile;

@Service
public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public ProfileService() {
		profiles.put("Mohan", new Profile(1, "Mohan Kolsetti", "Mohan", "Kolisetti"));
		profiles.put("Naveen", new Profile(2, "Naveen Polisetty", "Naveen", "Polisetty"));
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.values().stream().mapToLong(m -> m.getId()).max().getAsLong() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public void removeProfile(String profileName) {
		profiles.remove(profileName);
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

}
