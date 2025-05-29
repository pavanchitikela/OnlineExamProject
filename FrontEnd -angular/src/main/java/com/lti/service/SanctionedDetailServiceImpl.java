package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.SanctionDto;
import com.lti.entity.SanctionedDetail;
import com.lti.exception.HomeLoanException;
import com.lti.repository.SanctionedDetailRepo;

@Service
public class SanctionedDetailServiceImpl implements SanctionedDetailService {

	@Autowired
	private SanctionedDetailRepo sanctionedDetailServiceImpl;
	
	@Override
	public SanctionDto getSanctionedDetailByAccNo(int accountNo) {
		try {
			SanctionedDetail sanctionedDetail = sanctionedDetailServiceImpl.getSanctionedDetailByAccountNo(accountNo);
			if (sanctionedDetail==null) {
				throw new HomeLoanException("Invalid Account No.");
			} else {
				try {
					SanctionDto sanctionDto = new SanctionDto();
					sanctionDto.setAccountNo(sanctionedDetail.getAccountNo());
					sanctionDto.setBalanceAmount(sanctionedDetail.getBalanceAmount());
					sanctionDto.setEmi(sanctionedDetail.getEmi());
					return sanctionDto;
				} catch (Exception e) {
					throw new HomeLoanException("Unable to fetch");
				}
			}
		} catch (HomeLoanException e) {
			throw e;
		}
	}

}
