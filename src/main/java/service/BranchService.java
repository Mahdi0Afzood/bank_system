package service;

import model.Branch;
import repository.BankRepository;
import repository.BranchRepository;

import java.sql.SQLException;

public class BranchService {
    private BranchRepository branchRepository;
    private BankRepository bankRepository;

    public void add(String name, String address) throws SQLException, ClassNotFoundException {
        branchRepository = new BranchRepository();
        Branch branch = new Branch(-1, null , address, -1, -1, null , null);
        bankRepository = new BankRepository();
        int id = bankRepository.find(name);
        if (id != -1) branchRepository.add(id, branch);
    }

    public void find(int id) throws SQLException, ClassNotFoundException {
        branchRepository = new BranchRepository();
        Branch branch = new Branch(-1, null , null, -1, id, null , null);
        branchRepository.find(branch);
    }

    public void findAll(String name) throws SQLException, ClassNotFoundException {
        branchRepository = new BranchRepository();
        Branch branch = new Branch(-1, name , null, -1, -1 , null , null);
        branchRepository.find(branch);
    }

    public void update(int id, String address) throws SQLException, ClassNotFoundException {
        branchRepository = new BranchRepository();
        Branch branch = new Branch(-1, null , address, -1, id , null , null);
        branchRepository.update(branch);
    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        branchRepository = new BranchRepository();
        Branch branch = new Branch(-1, null , null, -1, id , null , null);
        branchRepository.delete(branch);
    }




}
