package com.example.lomantiy.repos;

import com.example.lomantiy.domain.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactRepository extends PagingAndSortingRepository<Contact,Long> {

}
