package de.adesso.uebung1;

import org.springframework.web.bind.annotation.GetMapping;

public interface AdessiRestInterface {
	/**
	 * @return the adessi's first name.
	 */
	@GetMapping("/adessi/firstName")
    String getFirstName();
	
	/**
	 * @return the adessi's last name.
	 */
	@GetMapping("/adessi/lastName")
	String getLastName();

	/**
	 * @return the adessi's line of business.
	 */
	@GetMapping("/adessi/lob")
	String getLineOfBusiness();
	
	/**
	 * @return the adessi's competence center.
	 */
	@GetMapping("/adessi/cc")
	String getCompetenceCenter();

	/**
	 * @return leader of the adessi's competence center.
	 */
	@GetMapping("/adessi/ccleader")
	String getCompetenceCenterLeader();
	
	/**
	 * @return the adessi's job description. Everything that has to be or can be said about the adessi's work at adesso.
	 */
	@GetMapping("/adessi/job")
	String getJobDescription();
}