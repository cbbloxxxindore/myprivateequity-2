package com.vanguard.retail.myprivateequity.webservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vanguard.retail.myprivateequity.webservice.models.Investor;

@Repository
public interface InvestorRepo extends JpaRepository<Investor, Integer> {

}
