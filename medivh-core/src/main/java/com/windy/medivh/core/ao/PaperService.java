package com.windy.medivh.core.ao;


import com.windy.medivh.core.model.AddPaperCommand;
import com.windy.medivh.dal.model.FpMaterialFileDO;

import java.util.List;

public interface PaperService {
    FpMaterialFileDO findBy(Long id);

    FpMaterialFileDO findWithNoContentBy(Long id);

    List<FpMaterialFileDO> findBy(List<Long> ids);

    void remove(Long fileId);

    Long add(AddPaperCommand command) throws Exception;
}
