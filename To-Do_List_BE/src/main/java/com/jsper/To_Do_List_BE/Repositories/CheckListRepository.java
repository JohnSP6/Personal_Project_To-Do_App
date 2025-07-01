package com.jsper.To_Do_List_BE.Repositories;

import com.jsper.To_Do_List_BE.Models.CheckList;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CheckListRepository extends MongoRepository<CheckList, String> {

    List<CheckList> findAllCheckListsByUserId(String id);

}
