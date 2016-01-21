package com.tn.isamm.voyageur.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.tn.isamm.voyageur.beans.Client;
import com.tn.isamm.voyageur.beans.Contact;
import com.tn.isamm.voyageur.beans.Fidelite;
import com.tn.isamm.voyageur.beans.Newsletter;
import com.tn.isamm.voyageur.beans.Voyage;
import com.tn.isamm.voyageur.service.ClientService;
import com.tn.isamm.voyageur.service.ContactService;
import com.tn.isamm.voyageur.service.NewsletterService;
import com.tn.isamm.voyageur.service.FideliteService;
import com.tn.isamm.voyageur.service.VoyageService;

@Controller
@RequestMapping("/")
@SessionAttributes("utilisateur")
public class AppController {

	
	@Autowired
	VoyageService voyageService;

	@Autowired
	ClientService clientService;

	@Autowired
	NewsletterService newsletterService;
	
	@Autowired
	FideliteService fideliteService;

	@Autowired
	ContactService contactService;


	@Autowired
	MessageSource messageSource;

	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/log", "/login" }, method = RequestMethod.POST)
	public String Login(BindingResult result, @PathVariable String mdp, @PathVariable String login, ModelMap model) {

		if (!clientService.isValidUser(login, mdp)) {
			model.addAttribute("error", "verifier votre mo de passe ou login");
			return "login";

		}

		return "listclient";
	}

	@RequestMapping(value = { "/log", "/login" }, method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "login";
	}

	// ---------------------Voyage----------------------------

	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = {"/", "/listvoyage" }, method = RequestMethod.GET)
	public String listVoyages(ModelMap model) {

		List<Voyage> voyages = voyageService.findAllVoyages();
		model.addAttribute("voyages", voyages);
		return "voyageslist";
	}

	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newvoyage" }, method = RequestMethod.GET)
	public String newVoyage(ModelMap model) {
		Voyage voyage = new Voyage();
		model.addAttribute("voyage", voyage);

		model.addAttribute("edit", false);

		return "voyageregistration";
	}

	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-voyage-{idVoyage}" }, method = RequestMethod.GET)
	public String editVoyage(@PathVariable String idVoyage, ModelMap model) {
		Voyage voyage = voyageService.findById(Integer.parseInt(idVoyage));
		model.addAttribute("voyage", voyage);
		model.addAttribute("edit", true);
		return "voyageregistration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newvoyage" }, method = RequestMethod.POST)
	public String saveVoyage(@Valid Voyage voyage, BindingResult result, ModelMap model) {
		voyage.setNbVendu(0);

		if (result.hasErrors()) {
			return "voyageregistration";
		}

		voyageService.saveVoyage(voyage);

		model.addAttribute("success", "Voyage " + voyage.getIdVoyage() + " de " + voyage.getVilleDepart() + " vers "
				+ voyage.getVilleArrivee() + " registered successfully");
		return "registrationsuccess";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-voyage-{idVoyage}" }, method = RequestMethod.POST)
	public String updateUser(@Valid Voyage voyage, BindingResult result, ModelMap model,
			@PathVariable Integer idVoyage) {

		if (result.hasErrors()) {
			return "voyageregistration";
		}

		voyageService.updateVoyage(voyage);

		model.addAttribute("success", "Voyage " + voyage.getIdVoyage() + " de " + voyage.getVilleDepart() + " vers "
				+ voyage.getVilleArrivee() + " registered successfully");
		return "registrationsuccess";
	}

	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-voyage-{voyageId}" }, method = RequestMethod.GET)
	public String deleteVoyage(@PathVariable String voyageId) {
		voyageService.deleteVoyage(Integer.parseInt(voyageId));
		return "redirect:/listvoyage";
	}

	// ---------------------Fin Voyage----------------------------

	// ---------------------Client----------------------------

	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/list", "/listclient" }, method = RequestMethod.GET)
	public String listClients(ModelMap model) {

		List<Client> clients = clientService.findAllClients();
		model.addAttribute("clients", clients);
		return "clientslist";
	}

	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newclient" }, method = RequestMethod.GET)
	public String newClient(ModelMap model) {
		Client client = new Client();
		model.addAttribute("client", client);

		model.addAttribute("edit", false);

		return "clientregistration";
	}

	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-client-{idClient}" }, method = RequestMethod.GET)
	public String editClient(@PathVariable String idClient, ModelMap model) {
		Client client = clientService.findById(Integer.parseInt(idClient));
		model.addAttribute("client", client);
		model.addAttribute("edit", true);
		return "clientregistration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newclient" }, method = RequestMethod.POST)
	public String saveClient(@Valid Client client, BindingResult result, ModelMap model) {

		// if (result.hasErrors()) {
		// return "clientregistration";
		// }

		clientService.saveClient(client);

		model.addAttribute("success", "Client " + client.getIdClient() + "  " + client.getPrenom() + "  "
				+ client.getNom() + " registered successfully");
		return "registrationsuccess";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-client-{idClient}" }, method = RequestMethod.POST)
	public String updateUser(@Valid Client client, BindingResult result, ModelMap model,
			@PathVariable Integer idClient) {

		if (result.hasErrors()) {
			return "clientregistration";
		}

		clientService.updateClient(client);

		model.addAttribute("success", "Client " + client.getIdClient() + " de " + client.getPrenom() + " vers "
				+ client.getNom() + " registered successfully");
		return "registrationsuccess";
	}

	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-client-{clientId}" }, method = RequestMethod.GET)
	public String deleteClient(@PathVariable String clientId) {
		clientService.deleteClient(Integer.parseInt(clientId));
		return "redirect:/listclient";
	}

	// ---------------------Fin Client----------------------------

	// ---------------------Fidelite----------------------------

	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/listfidelite" }, method = RequestMethod.GET)
	public String listFidelites(ModelMap model) {

		List<Fidelite> fidelites = fideliteService.findAllFidelites();
		model.addAttribute("fidelites", fidelites);
		return "fideliteslist";
	}

	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newfidelite" }, method = RequestMethod.GET)
	public String newFidelite(ModelMap model) {
		Fidelite fidelite = new Fidelite();
		model.addAttribute("fidelite", fidelite);

		model.addAttribute("edit", false);

		return "fideliteregistration";
	}

	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-fidelite-{idFidelite}" }, method = RequestMethod.GET)
	public String editFidelite(@PathVariable String idFidelite, ModelMap model) {
		Fidelite fidelite = fideliteService.findById(Integer.parseInt(idFidelite));
		model.addAttribute("fidelite", fidelite);
		model.addAttribute("edit", true);
		return "fideliteregistration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newfidelite" }, method = RequestMethod.POST)
	public String saveFidelite(@Valid Fidelite fidelite, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "fideliteregistration";
		}

		fideliteService.saveFidelite(fidelite);

		model.addAttribute("success", "Fidelite " + fidelite.getIdFidelite() + " : " + fidelite.getFd()
				+ " registered successfully");
		return "registrationsuccess";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-fidelite-{idFidelite}" }, method = RequestMethod.POST)
	public String updateUser(@Valid Fidelite fidelite, BindingResult result, ModelMap model,
			@PathVariable Integer idFidelite) {

		if (result.hasErrors()) {
			return "fideliteregistration";
		}

		fideliteService.updateFidelite(fidelite);

		model.addAttribute("success", "Fidelite " + fidelite.getIdFidelite() + " : " + fidelite.getFd()
				+ " registered successfully");
		return "registrationsuccess";
	}

	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-fidelite-{fideliteId}" }, method = RequestMethod.GET)
	public String deleteFidelite(@PathVariable String fideliteId) {
		fideliteService.deleteFidelite(Integer.parseInt(fideliteId));
		return "redirect:/listfidelite";
	}

	// ---------------------Fin Fidelite----------------------------

	
	// ---------------------Newsletter----------------------------

	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/listnewsletter" }, method = RequestMethod.GET)
	public String listNewsletters(ModelMap model) {

		List<Newsletter> newsletters = newsletterService.findAllNewsletters();
		model.addAttribute("newsletters", newsletters);
		return "newsletterslist";
	}

	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newnewsletter" }, method = RequestMethod.GET)
	public String newNewsletter(ModelMap model) {
		Newsletter newsletter = new Newsletter();
		model.addAttribute("newsletter", newsletter);

		model.addAttribute("edit", false);

		return "newsletterregistration";
	}

	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-newsletter-{idNewsletter}" }, method = RequestMethod.GET)
	public String editNewsletter(@PathVariable String idNewsletter, ModelMap model) {
		Newsletter newsletter = newsletterService.findById(Integer.parseInt(idNewsletter));
		model.addAttribute("newsletter", newsletter);
		model.addAttribute("edit", true);
		return "newsletterregistration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newnewsletter" }, method = RequestMethod.POST)
	public String saveNewsletter(@Valid Newsletter newsletter, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "newsletterregistration";
		}

		newsletterService.saveNewsletter(newsletter);

		model.addAttribute("success", "Newsletter " + newsletter.getIdNewsletter() + " : " + newsletter.getMail()
				+ " registered successfully");
		return "registrationsuccess";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-newsletter-{idNewsletter}" }, method = RequestMethod.POST)
	public String updateUser(@Valid Newsletter newsletter, BindingResult result, ModelMap model,
			@PathVariable Integer idNewsletter) {

		if (result.hasErrors()) {
			return "newsletterregistration";
		}

		newsletterService.updateNewsletter(newsletter);

		model.addAttribute("success", "Newsletter " + newsletter.getIdNewsletter() + " : " + newsletter.getMail()
				+ " registered successfully");
		return "registrationsuccess";
	}

	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-newsletter-{newsletterId}" }, method = RequestMethod.GET)
	public String deleteNewsletter(@PathVariable String newsletterId) {
		newsletterService.deleteNewsletter(Integer.parseInt(newsletterId));
		return "redirect:/listnewsletter";
	}

	// ---------------------Fin Newsletter----------------------------

	
	// ---------------------Contact----------------------------

	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/listcontact" }, method = RequestMethod.GET)
	public String listContacts(ModelMap model) {

		List<Contact> contacts = contactService.findAllContacts();

		model.addAttribute("contacts", contacts);
		return "contactslist";
	}

	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newcontact" }, method = RequestMethod.GET)
	public String newContact(ModelMap model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		List<Client> clients = clientService.findAllClients();

		model.addAttribute("clients", clients);

		model.addAttribute("edit", false);

		return "contactregistration";
	}

	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-contact-{idContact}" }, method = RequestMethod.GET)
	public String editContact(@PathVariable String idContact, ModelMap model) {
		List<Client> clients = clientService.findAllClients();

		model.addAttribute("clients", clients);
		Contact contact = contactService.findById(Integer.parseInt(idContact));
		model.addAttribute("contact", contact);
		model.addAttribute("edit", true);
		return "contactregistration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newcontact" }, method = RequestMethod.POST)
	public String saveContact(@Valid Contact contact, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "contactregistration";
		}

		contactService.saveContact(contact);

		model.addAttribute("success", "Contact " + contact.getSujet() + " registered successfully");
		return "registrationsuccess";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-contact-{idContact}" }, method = RequestMethod.POST)
	public String updateUser(@Valid Contact contact, BindingResult result, ModelMap model,
			@PathVariable Integer idContact) {

		if (result.hasErrors()) {
			return "contactregistration";
		}

		contactService.updateContact(contact);

		model.addAttribute("success",
				"Contact " + contact.getIdContact() + " de sujet  " + contact.getSujet() + " registered successfully");
		return "registrationsuccess";
	}

	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-contact-{contactId}" }, method = RequestMethod.GET)
	public String deleteContact(@PathVariable String contactId) {
		contactService.deleteContact(Integer.parseInt(contactId));
		return "redirect:/listcontact";
	}

	// ---------------------Fin Contact----------------------------

	//-------------------------recherche----------------------
	@RequestMapping(value = {"/recherche" }, method = RequestMethod.GET)
	public String Recherche(ModelMap model) {

		
		
		return "recherche";
	}
	
	@RequestMapping(value = {"/recherche" }, method = RequestMethod.POST)
	public String RecherchePOST(@RequestParam String  type , @RequestParam String value,ModelMap model) {
		
		if(type.equals("client")){
		
		List<Client> clients = clientService.findByString(value);
		model.addAttribute("clients", clients);
		}else{
		List<Voyage> voyages = voyageService.findByString(value);
		model.addAttribute("voyages", voyages);
		}
		return "recherche";
	}
	//-------------------------fin recherche------------------
}
