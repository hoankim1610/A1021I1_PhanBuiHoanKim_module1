package com.example.sprint2_be.repository.payload.response;

import com.example.sprint2_be.entity.account.Account;

public class JwtResponse {
	private Account account;
	private String jwtToken;

	public JwtResponse(Account account , String jwtToken) {
		this.account = account;
		this.jwtToken = jwtToken;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
}