package com.example.lomantiy;

import com.example.lomantiy.domain.Address;
import com.example.lomantiy.domain.Contact;
import com.example.lomantiy.domain.Name;
import com.example.lomantiy.domain.Phone;
import com.example.lomantiy.repos.ContactRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
class ContactTests {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private  TestEntityManager entityManager;
	private static Contact contact=null;
    @BeforeEach
	public void contactPersist(){
		Address address = new Address("324 peyton ct", "Charlotessville","VA","22903");
		Name name = new Name("Dawit","Alemayohu","Kahsay");
		Phone phone1 = new Phone("4344666789","phone");
		List<Phone> phones = new ArrayList<>();
		phones.add(phone1);
		String email = "davealexkas@gmail.com";
		contact = new Contact(name,address,phones,email);
		entityManager.persist(contact);
		entityManager.flush();
	}
	@Test
	public void testFindById(){

		Contact newContact = contactRepository.findById(contact.getId()).get();
		assertThat(newContact.getId(),is(equalTo(contact.getId())));
	}
	@Test
	public void update(){
		Contact newContact = entityManager.find(Contact.class,contact.getId());
		newContact.setEmail("kashasy@yahoo.com");
		newContact = entityManager.merge(newContact);
		assertThat(newContact.getId(),is(equalTo(contact.getId())));
	}
	@Test
	public void delete(){
		long id = entityManager.persistAndGetId(contact,Long.class);
		contactRepository.deleteById(id);
		entityManager.flush();
		Contact newContact = entityManager.find(Contact.class, id);
		assertNull(newContact);
	}

}
