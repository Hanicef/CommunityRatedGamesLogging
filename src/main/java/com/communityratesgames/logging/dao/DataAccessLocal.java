package com.communityratesgames.logging.dao;

import com.communityratesgames.logging.domain.Logging;

import javax.ejb.Local;

@Local
public interface DataAccessLocal {

    public Logging addNewLog(Logging log);
}
