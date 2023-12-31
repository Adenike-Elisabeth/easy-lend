package com.decagon.service;

import com.decagon.dto.pojoDTO.*;
import com.decagon.dto.response.ProfileResponseDTO;
import org.springframework.web.multipart.MultipartFile;

public interface ProfileService {
    ProfileResponseDTO createProfile(String user_id, ContactInformationDTO contactInformation);

    String updateContactInformation(ContactInformationDTO contactInfo, String authorizationHeader);

    ProfileResponseDTO updateEmploymentStatus(EmploymentStatusDTO employmentStatus, String authorizationHeader);

    ProfileResponseDTO updateGovernmentID(GovernmentIDDTO governmentID, MultipartFile file, String authorizationHeader);

    ProfileResponseDTO updateIncomeStatus(IncomeStatusDTO incomeStatus, String authorizationHeader);
    Object getContact(String auth);

    ProfileResponseDTO updateBankAccount(BankAccountDTO bankAccount, String authorizationHeader);

    ProfileResponseDTO updateProofOfAddress(ProofOfAddressDTO proofOfAddress, MultipartFile file, String authorizationHeader);
}