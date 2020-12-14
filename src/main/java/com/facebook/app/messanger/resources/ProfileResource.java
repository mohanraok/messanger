package com.facebook.app.messanger.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.app.messanger.model.Profile;
import com.facebook.app.messanger.service.ProfileService;

@RestController
@RequestMapping("/messanger/profiles")
public class ProfileResource {

	@Autowired
	ProfileService profileService;

	@GetMapping
	public List<Profile> getAllProfiles() {
		return profileService.getAllProfiles();
	}

	@GetMapping("{profileName}")
	public Profile getProfile(@PathVariable String profileName) {
		return profileService.getProfile(profileName);
	}

	@PostMapping
	public Profile addProfile(@RequestBody Profile profile) {
		return profileService.addProfile(profile);
	}

	@PutMapping("{profileName}")
	public Profile updateMessage(@PathVariable String profileName, @RequestBody Profile profile) {
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}

	@DeleteMapping("{profileName}")
	public void updateMessage(@PathVariable String profileName) {
		profileService.removeProfile(profileName);
	}

}
