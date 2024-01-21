--------------------------------------------------------
--  File created - Friday-December-09-2022   
--------------------------------------------------------
DROP TABLE "SYSTEM"."NVDIETPLAN";
--------------------------------------------------------
--  DDL for Table NVDIETPLAN
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."NVDIETPLAN" 
   (	"NONVEG_ID" NUMBER(*,0), 
	"BREAKFAST" VARCHAR2(100 BYTE), 
	"LUNCH" VARCHAR2(100 BYTE), 
	"DINNER" VARCHAR2(100 BYTE), 
	"USER_ID" VARCHAR2(10 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.NVDIETPLAN
SET DEFINE OFF;
Insert into SYSTEM.NVDIETPLAN (NONVEG_ID,BREAKFAST,LUNCH,DINNER,USER_ID) values (3,'Brown Bread with 1 cup of milk(no sugar)','low fat curd with green salad','1 cup Pumpkin + Chapati and salad','4');
Insert into SYSTEM.NVDIETPLAN (NONVEG_ID,BREAKFAST,LUNCH,DINNER,USER_ID) values (4,'boiled egg and hot lemon honey drink','Boiled pulses','steamed rice and 1 bowl of chek pea curry','2');
Insert into SYSTEM.NVDIETPLAN (NONVEG_ID,BREAKFAST,LUNCH,DINNER,USER_ID) values (6,'Cucumber drink and egg omlet','Boiled chicken','Chek pea and salad','1');
Insert into SYSTEM.NVDIETPLAN (NONVEG_ID,BREAKFAST,LUNCH,DINNER,USER_ID) values (7,'Tofu and fruits','low fat curd and 150gms turkey','Mix-veg salad and mashed potato','6');
--------------------------------------------------------
--  DDL for Index SYS_C008381
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."SYS_C008381" ON "SYSTEM"."NVDIETPLAN" ("NONVEG_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table NVDIETPLAN
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."NVDIETPLAN" MODIFY ("USER_ID" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."NVDIETPLAN" ADD PRIMARY KEY ("NONVEG_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table NVDIETPLAN
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."NVDIETPLAN" ADD FOREIGN KEY ("USER_ID")
	  REFERENCES "SYSTEM"."USERS" ("USER_ID") ON DELETE CASCADE ENABLE;
