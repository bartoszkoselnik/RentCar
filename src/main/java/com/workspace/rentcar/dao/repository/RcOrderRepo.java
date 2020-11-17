package com.workspace.rentcar.dao.repository;

import com.workspace.rentcar.dao.entity.RcOrder;
import org.springframework.data.repository.CrudRepository;

public interface RcOrderRepo extends CrudRepository<RcOrder, Long> {
}
