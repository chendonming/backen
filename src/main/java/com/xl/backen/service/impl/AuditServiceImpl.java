package com.xl.backen.service.impl;

import com.xl.backen.dao.PartyRememberMapper;
import com.xl.backen.entity.PartyRemember;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class AuditServiceImpl implements AuditService {
  @Autowired
  private PartyRememberMapper rm;

  @Override
  public int partyRememberAudit(PartyRemember partyRemember) {
    valid(partyRemember);

    // 假设： 在用户注册的timing时已经静默完成党员认证

    // 通过
    if (partyRemember.getStatus() == 1) {
      PartyRemember p = new PartyRemember();
      p.setUuid(UUID.randomUUID().toString().replace("-", ""));
      p.setCreateTime(new Date());
      p.setUpdateTime(new Date());
      p.setUserId(partyRemember.getUuid());
      p.setTruename(partyRemember.getTruename());
      p.setPhone(partyRemember.getPhone());
      p.setType(1);
      rm.insert(p);
    } else {
      // 驳回
    }

    return 0;
  }

  private void valid(PartyRemember partyRemember) {
    if (partyRemember.getType() != 1) {
      throw new BusinessException(800, "不是直管党员不需要审核");
    }
  }
}
