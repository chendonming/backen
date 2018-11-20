package com.xl.backen.service;

import com.xl.backen.entity.PartyRemember;

/**
 * 审核
 */
public interface AuditService {
  /**
   * 审核直管党员
   * @param partyRemember
   * @return
   */
  int partyRememberAudit(PartyRemember partyRemember);
}
