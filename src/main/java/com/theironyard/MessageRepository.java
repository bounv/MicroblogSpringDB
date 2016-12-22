package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by boun on 12/21/16.
 */

public interface MessageRepository extends CrudRepository<Message, Integer> {

}