package com.vlad.circledevs_test.util.facades;

import com.vlad.circledevs_test.models.DTO.BankDTO;
import com.vlad.circledevs_test.models.entity.Bank;
import com.vlad.circledevs_test.services.interfaces.BankService;
import com.vlad.circledevs_test.util.facades.interfaces.BankFacade;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankFacadeImpl implements BankFacade {
  ModelMapper modelMapper = new ModelMapper();
  BankService bankService;

  public BankFacadeImpl(BankService bankService) {
    this.bankService = bankService;
  }

  @Override
  public List<BankDTO> getAll() {
    return bankService.findAll()
            .stream()
            .map(bank -> modelMapper.map(bank, BankDTO.class))
            .toList();
  }

  @Override
  public BankDTO getById(Integer id) {
    return modelMapper.map(bankService.findById(id), BankDTO.class);
  }

  @Override
  public void delete(BankDTO bankDTO) {
    bankService.delete(modelMapper.map(bankDTO, Bank.class));

  }

  @Override
  public BankDTO create(BankDTO bank) {
    Bank newBank = bankService.save(modelMapper.map(bank, Bank.class));
    return modelMapper.map(newBank, BankDTO.class);
  }

  @Override
  public Boolean existById(int id) {
    return bankService.existsById(id);
  }

  @Override
  public Boolean existBankByTitle(String title) {
    return bankService.existBankByTitle(title);
  }
}
