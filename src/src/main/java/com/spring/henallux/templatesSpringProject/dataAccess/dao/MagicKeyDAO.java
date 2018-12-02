package com.spring.henallux.templatesSpringProject.dataAccess.dao;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.MagicKeyEntity;
import com.spring.henallux.templatesSpringProject.dataAccess.repository.MagicKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MagicKeyDAO {

    private MagicKeyRepository magicKeyRepository;

    @Autowired
    public MagicKeyDAO(MagicKeyRepository magicKeyRepository) {
        this.magicKeyRepository = magicKeyRepository;
    }

    public ArrayList<String> getMagicKeys()
    {
        List<MagicKeyEntity> magicKeyEntities = magicKeyRepository.findAll();
        ArrayList<String> magicKeysStrings = new ArrayList<String>();
        for (MagicKeyEntity magicKey : magicKeyEntities) {
            magicKeysStrings.add(magicKey.getMagicvalue());
        }
        return magicKeysStrings;
    }

}
