--------------------------------------------------------
--  File created - Friday-December-09-2022   
--------------------------------------------------------
DROP TABLE "SYSTEM"."STATUS";
--------------------------------------------------------
--  DDL for Table STATUS
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."STATUS" 
   (	"STATUS" VARCHAR2(50 BYTE), 
	"USER_ID" VARCHAR2(50 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.STATUS
SET DEFINE OFF;
Insert into SYSTEM.STATUS (STATUS,USER_ID) values ('Confirmed','2');
Insert into SYSTEM.STATUS (STATUS,USER_ID) values ('Confirmed','2');
Insert into SYSTEM.STATUS (STATUS,USER_ID) values ('Confirmed','2');
--------------------------------------------------------
--  Constraints for Table STATUS
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."STATUS" MODIFY ("STATUS" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."STATUS" MODIFY ("USER_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table STATUS
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."STATUS" ADD FOREIGN KEY ("USER_ID")
	  REFERENCES "SYSTEM"."USERS" ("USER_ID") ON DELETE CASCADE ENABLE;
