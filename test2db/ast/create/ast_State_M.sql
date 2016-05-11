DROP TABLE IF EXISTS `ast_State_M`;

CREATE TABLE `ast_State_M` ( `stateId` VARCHAR(64) NOT NULL, `countryId` VARCHAR(64) NOT NULL, `stateName` VARCHAR(256) NOT NULL, `stateCode` INT(2) NULL DEFAULT NULL, `stateCodeChar2` VARCHAR(32) NOT NULL, `stateCodeChar3` VARCHAR(32) NULL DEFAULT NULL, `stateDescription` VARCHAR(256) NULL DEFAULT NULL, `stateFlag` VARCHAR(128) NULL DEFAULT NULL, `stateCapital` VARCHAR(128) NULL DEFAULT NULL, `stateCapitalLatitude` INT(11) NULL DEFAULT NULL, `stateCapitalLongitude` INT(11) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` TIMESTAMP NULL DEFAULT '2000-01-01 10:10:10', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` TIMESTAMP NULL DEFAULT '2000-01-01 10:10:10', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`stateId`));
