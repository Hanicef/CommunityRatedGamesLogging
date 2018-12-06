package com.communityratesgames.logging.dao;

import com.communityratesgames.logging.domain.Logging;
import com.communityratesgames.logging.transactions.LoggingDataMethods;

import javax.inject.Inject;

public class LoggingDataAccess implements DataAccessLocal, DataAccessRemote {

    @Inject
    private LoggingDataMethods loggingDataMethods;

    @Override
    public Logging addNewLog(Logging log) {return loggingDataMethods.addNewLog(log);}
}
