--------------------------------------------------------
--  File created - Friday-December-09-2022   
--------------------------------------------------------
DROP TABLE "SYSTEM"."VDIETPLAN";
--------------------------------------------------------
--  DDL for Table VDIETPLAN
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."VDIETPLAN" 
   (	"VEG_ID" NUMBER(*,0), 
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
REM INSERTING into SYSTEM.VDIETPLAN
SET DEFINE OFF;
Insert into SYSTEM.VDIETPLAN (VEG_ID,BREAKFAST,LUNCH,DINNER,USER_ID) values (1,'1 Smoothie and Fruit-Salad','Tortilla bread + Avocado','Rice with cereals and pulses','5');
Insert into SYSTEM.VDIETPLAN (VEG_ID,BREAKFAST,LUNCH,DINNER,USER_ID) values (2,'green Vegetable Salad','Have 1 seasonal whole fruit (no juice)','Khichdi','3');
Insert into SYSTEM.VDIETPLAN (VEG_ID,BREAKFAST,LUNCH,DINNER,USER_ID) values (5,'1 milk shake and Fruit-Salad','Tortilla bread + Jam','Rice with chek pea curry','3');
Insert into SYSTEM.VDIETPLAN (VEG_ID,BREAKFAST,LUNCH,DINNER,USER_ID) values (3,'Brown Bread with 1 cup of milk(no sugar)','low fat curd with green salad','Boiled chek pea + Chapati and salad','4');
Insert into SYSTEM.VDIETPLAN (VEG_ID,BREAKFAST,LUNCH,DINNER,USER_ID) values (4,'green leafy Vegetable Salad','Have 1 seasonal whole fruit','Khichdi','2');
Insert into SYSTEM.VDIETPLAN (VEG_ID,BREAKFAST,LUNCH,DINNER,USER_ID) values (6,'Brown Bread with 1 cup of fresh fruit juice(no sugar)','low fat curd with mashed potato','1 cup Pumpkin + Chapati and salad','5');
--------------------------------------------------------
--  DDL for Index SYS_C008378
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."SYS_C008378" ON "SYSTEM"."VDIETPLAN" ("VEG_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table VDIETPLAN
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."VDIETPLAN" MODIFY ("USER_ID" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."VDIETPLAN" ADD PRIMARY KEY ("VEG_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table VDIETPLAN
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."VDIETPLAN" ADD FOREIGN KEY ("USER_ID")
	  REFERENCES "SYSTEM"."USERS" ("USER_ID") ON DELETE CASCADE ENABLE;
