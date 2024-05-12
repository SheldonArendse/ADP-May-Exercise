package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Contact;

import java.util.List;

@Repository
public interface IContactRepository extends JpaRepository<Contact, String> {
    public List<Contact> findContactByMobile(String s);
}
