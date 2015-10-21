--------------------------------------------------
-- Export file for user ES                      --
-- Created by junfu.chen on 2015/8/31, 12:55:01 --
--------------------------------------------------

set define off
spool es-schema.log

prompt
prompt Creating table MAINTAIN_ICON
prompt ============================
prompt
create table MAINTAIN_ICON
(
  id          NUMBER(19) not null,
  css_class   VARCHAR2(255 CHAR),
  description VARCHAR2(255 CHAR),
  height      NUMBER(10),
  identity    VARCHAR2(255 CHAR),
  img_src     VARCHAR2(255 CHAR),
  left        NUMBER(10),
  sprite_src  VARCHAR2(255 CHAR),
  style       VARCHAR2(255 CHAR),
  top         NUMBER(10),
  type        VARCHAR2(255 CHAR),
  width       NUMBER(10)
)
;
alter table MAINTAIN_ICON
  add primary key (ID);

prompt
prompt Creating table MAINTAIN_MAP
prompt ===========================
prompt
create table MAINTAIN_MAP
(
  id        NUMBER(19) not null,
  map_key   VARCHAR2(255 CHAR),
  map_value VARCHAR2(255 CHAR)
)
;
alter table MAINTAIN_MAP
  add primary key (ID);

prompt
prompt Creating table MAINTAIN_NOTIFICATION_DATA
prompt =========================================
prompt
create table MAINTAIN_NOTIFICATION_DATA
(
  id      NUMBER(19) not null,
  content VARCHAR2(255 CHAR),
  ts      TIMESTAMP(6),
  is_read NUMBER(1),
  system  VARCHAR2(255 CHAR),
  title   VARCHAR2(255 CHAR),
  user_id NUMBER(19)
)
;
alter table MAINTAIN_NOTIFICATION_DATA
  add primary key (ID);

prompt
prompt Creating table MAINTAIN_NOTIFICATION_TEMPLATE
prompt =============================================
prompt
create table MAINTAIN_NOTIFICATION_TEMPLATE
(
  id       NUMBER(19) not null,
  deleted  NUMBER(1),
  name     VARCHAR2(255 CHAR),
  system   VARCHAR2(255 CHAR),
  template VARCHAR2(255 CHAR),
  title    VARCHAR2(255 CHAR)
)
;
alter table MAINTAIN_NOTIFICATION_TEMPLATE
  add primary key (ID);

prompt
prompt Creating table MAINTAIN_TASK_DEFINITION
prompt =======================================
prompt
create table MAINTAIN_TASK_DEFINITION
(
  id          NUMBER(19) not null,
  bean_class  VARCHAR2(255 CHAR),
  bean_name   VARCHAR2(255 CHAR),
  cron        VARCHAR2(255 CHAR),
  description VARCHAR2(255 CHAR),
  method_name VARCHAR2(255 CHAR),
  name        VARCHAR2(255 CHAR),
  is_start    NUMBER(1)
)
;
alter table MAINTAIN_TASK_DEFINITION
  add primary key (ID);

prompt
prompt Creating table PERSONAL_CALENDAR
prompt ================================
prompt
create table PERSONAL_CALENDAR
(
  id               NUMBER(19) not null,
  background_color VARCHAR2(255 CHAR),
  details          VARCHAR2(255 CHAR),
  end_time         DATE,
  length           NUMBER(10),
  start_date       DATE,
  start_time       DATE,
  text_color       VARCHAR2(255 CHAR),
  title            VARCHAR2(255 CHAR),
  user_id          NUMBER(19)
)
;
alter table PERSONAL_CALENDAR
  add primary key (ID);

prompt
prompt Creating table PERSONAL_MESSAGE
prompt ===============================
prompt
create table PERSONAL_MESSAGE
(
  id                         NUMBER(19) not null,
  parent_id                  NUMBER(19),
  parent_ids                 VARCHAR2(255 CHAR),
  is_read                    NUMBER(1),
  receiver_id                NUMBER(19),
  receiver_state             VARCHAR2(255 CHAR),
  receiver_state_change_date TIMESTAMP(6),
  is_replied                 NUMBER(1),
  send_date                  TIMESTAMP(6),
  sender_id                  NUMBER(19),
  sender_state               VARCHAR2(255 CHAR),
  sender_state_change_date   TIMESTAMP(6),
  title                      VARCHAR2(255 CHAR),
  type                       VARCHAR2(255 CHAR)
)
;
alter table PERSONAL_MESSAGE
  add primary key (ID);

prompt
prompt Creating table PERSONAL_MESSAGE_CONTENT
prompt =======================================
prompt
create table PERSONAL_MESSAGE_CONTENT
(
  id         NUMBER(19) not null,
  content    VARCHAR2(255 CHAR),
  message_id NUMBER(19)
)
;
alter table PERSONAL_MESSAGE_CONTENT
  add primary key (ID);
alter table PERSONAL_MESSAGE_CONTENT
  add constraint FK_QFJWXOA6COASTM6O8XNCM2B3C foreign key (MESSAGE_ID)
  references PERSONAL_MESSAGE (ID);

prompt
prompt Creating table SHOWCASE_CATEGORY
prompt ================================
prompt
create table SHOWCASE_CATEGORY
(
  id      NUMBER(19) not null,
  name    VARCHAR2(255 CHAR),
  is_show NUMBER(1),
  weight  NUMBER(10)
)
;
alter table SHOWCASE_CATEGORY
  add primary key (ID);

prompt
prompt Creating table SHOWCASE_PARENT
prompt ==============================
prompt
create table SHOWCASE_PARENT
(
  id        NUMBER(19) not null,
  begindate DATE,
  enddate   DATE,
  name      VARCHAR2(255 CHAR),
  is_show   NUMBER(1),
  type      VARCHAR2(255 CHAR)
)
;
alter table SHOWCASE_PARENT
  add primary key (ID);

prompt
prompt Creating table SHOWCASE_CHILD
prompt =============================
prompt
create table SHOWCASE_CHILD
(
  id        NUMBER(19) not null,
  begintime TIMESTAMP(6),
  endtime   TIMESTAMP(6),
  name      VARCHAR2(255 CHAR),
  is_show   NUMBER(1),
  type      VARCHAR2(255 CHAR),
  parent_id NUMBER(19)
)
;
alter table SHOWCASE_CHILD
  add primary key (ID);
alter table SHOWCASE_CHILD
  add constraint FK_6B2GLJ1T21W6XX0NYOP2WOBVL foreign key (PARENT_ID)
  references SHOWCASE_PARENT (ID);

prompt
prompt Creating table SHOWCASE_EDITOR
prompt ==============================
prompt
create table SHOWCASE_EDITOR
(
  id      NUMBER(19) not null,
  content VARCHAR2(255 CHAR),
  title   VARCHAR2(255 CHAR)
)
;
alter table SHOWCASE_EDITOR
  add primary key (ID);

prompt
prompt Creating table SHOWCASE_EXCEL_DATA
prompt ==================================
prompt
create table SHOWCASE_EXCEL_DATA
(
  id      NUMBER(19) not null,
  content VARCHAR2(255 CHAR)
)
;
alter table SHOWCASE_EXCEL_DATA
  add primary key (ID);

prompt
prompt Creating table SHOWCASE_MOVEABLE
prompt ================================
prompt
create table SHOWCASE_MOVEABLE
(
  id      NUMBER(19) not null,
  name    VARCHAR2(255 CHAR),
  is_show NUMBER(1),
  weight  NUMBER(10)
)
;
alter table SHOWCASE_MOVEABLE
  add primary key (ID);

prompt
prompt Creating table SHOWCASE_PRODUCT
prompt ===============================
prompt
create table SHOWCASE_PRODUCT
(
  id          NUMBER(19) not null,
  begindate   TIMESTAMP(6),
  enddate     TIMESTAMP(6),
  name        VARCHAR2(255 CHAR),
  quantity    NUMBER(19),
  price       NUMBER(19),
  is_show     NUMBER(1),
  category_id NUMBER(19)
)
;
alter table SHOWCASE_PRODUCT
  add primary key (ID);
alter table SHOWCASE_PRODUCT
  add constraint FK_JO8FFWYJKL4XU8W4PBL10PDB7 foreign key (CATEGORY_ID)
  references SHOWCASE_CATEGORY (ID);

prompt
prompt Creating table SHOWCASE_SAMPLE
prompt ==============================
prompt
create table SHOWCASE_SAMPLE
(
  id       NUMBER(19) not null,
  age      NUMBER(10),
  birthday TIMESTAMP(6),
  deleted  NUMBER(1),
  name     VARCHAR2(255 CHAR),
  sex      VARCHAR2(255 CHAR),
  is_show  NUMBER(1)
)
;
alter table SHOWCASE_SAMPLE
  add primary key (ID);

prompt
prompt Creating table SHOWCASE_STATUS_AUDIT
prompt ====================================
prompt
create table SHOWCASE_STATUS_AUDIT
(
  id     NUMBER(19) not null,
  notes  VARCHAR2(255 CHAR),
  name   VARCHAR2(255 CHAR),
  status VARCHAR2(255 CHAR)
)
;
alter table SHOWCASE_STATUS_AUDIT
  add primary key (ID);

prompt
prompt Creating table SHOWCASE_STATUS_SHOW
prompt ===================================
prompt
create table SHOWCASE_STATUS_SHOW
(
  id     NUMBER(19) not null,
  name   VARCHAR2(255 CHAR),
  status VARCHAR2(255 CHAR)
)
;
alter table SHOWCASE_STATUS_SHOW
  add primary key (ID);

prompt
prompt Creating table SHOWCASE_TREE
prompt ============================
prompt
create table SHOWCASE_TREE
(
  id         NUMBER(19) not null,
  icon       VARCHAR2(255 CHAR),
  name       VARCHAR2(255 CHAR),
  parent_id  NUMBER(19),
  parent_ids VARCHAR2(255 CHAR),
  is_show    NUMBER(1),
  weight     NUMBER(10)
)
;
alter table SHOWCASE_TREE
  add primary key (ID);

prompt
prompt Creating table SHOWCASE_UPLOAD
prompt ==============================
prompt
create table SHOWCASE_UPLOAD
(
  id   NUMBER(19) not null,
  name VARCHAR2(255 CHAR),
  src  VARCHAR2(255 CHAR)
)
;
alter table SHOWCASE_UPLOAD
  add primary key (ID);

prompt
prompt Creating table SYS_AUTH
prompt =======================
prompt
create table SYS_AUTH
(
  id              NUMBER(19) not null,
  group_id        NUMBER(19),
  job_id          NUMBER(19),
  organization_id NUMBER(19),
  role_ids        VARCHAR2(255 CHAR),
  type            VARCHAR2(255 CHAR),
  user_id         NUMBER(19)
)
;
alter table SYS_AUTH
  add primary key (ID);

prompt
prompt Creating table SYS_GROUP
prompt ========================
prompt
create table SYS_GROUP
(
  id            NUMBER(19) not null,
  default_group NUMBER(1),
  name          VARCHAR2(255 CHAR),
  is_show       NUMBER(1),
  type          VARCHAR2(255 CHAR)
)
;
alter table SYS_GROUP
  add primary key (ID);

prompt
prompt Creating table SYS_GROUP_RELATION
prompt =================================
prompt
create table SYS_GROUP_RELATION
(
  id              NUMBER(19) not null,
  end_user_id     NUMBER(19),
  group_id        NUMBER(19),
  organization_id NUMBER(19),
  start_user_id   NUMBER(19),
  user_id         NUMBER(19)
)
;
alter table SYS_GROUP_RELATION
  add primary key (ID);

prompt
prompt Creating table SYS_JOB
prompt ======================
prompt
create table SYS_JOB
(
  id         NUMBER(19) not null,
  icon       VARCHAR2(255 CHAR),
  name       VARCHAR2(255 CHAR),
  parent_id  NUMBER(19),
  parent_ids VARCHAR2(255 CHAR),
  is_show    NUMBER(1),
  weight     NUMBER(10)
)
;
alter table SYS_JOB
  add primary key (ID);

prompt
prompt Creating table SYS_ORGANIZATION
prompt ===============================
prompt
create table SYS_ORGANIZATION
(
  id         NUMBER(19) not null,
  icon       VARCHAR2(255 CHAR),
  name       VARCHAR2(255 CHAR),
  parent_id  NUMBER(19),
  parent_ids VARCHAR2(255 CHAR),
  is_show    NUMBER(1),
  type       VARCHAR2(255 CHAR),
  weight     NUMBER(10)
)
;
alter table SYS_ORGANIZATION
  add primary key (ID);

prompt
prompt Creating table SYS_PERMISSION
prompt =============================
prompt
create table SYS_PERMISSION
(
  id          NUMBER(19) not null,
  description VARCHAR2(255 CHAR),
  name        VARCHAR2(255 CHAR),
  permission  VARCHAR2(255 CHAR),
  is_show     NUMBER(1)
)
;
alter table SYS_PERMISSION
  add primary key (ID);

prompt
prompt Creating table SYS_RESOURCE
prompt ===========================
prompt
create table SYS_RESOURCE
(
  id         NUMBER(19) not null,
  icon       VARCHAR2(255 CHAR),
  identity   VARCHAR2(255 CHAR),
  name       VARCHAR2(255 CHAR),
  parent_id  NUMBER(19),
  parent_ids VARCHAR2(255 CHAR),
  is_show    NUMBER(1),
  url        VARCHAR2(255 CHAR),
  weight     NUMBER(10)
)
;
alter table SYS_RESOURCE
  add primary key (ID);

prompt
prompt Creating table SYS_ROLE
prompt =======================
prompt
create table SYS_ROLE
(
  id          NUMBER(19) not null,
  description VARCHAR2(255 CHAR),
  name        VARCHAR2(255 CHAR),
  role        VARCHAR2(255 CHAR),
  is_show     NUMBER(1)
)
;
alter table SYS_ROLE
  add primary key (ID);

prompt
prompt Creating table SYS_ROLE_RESOURCE_PERMISSION
prompt ===========================================
prompt
create table SYS_ROLE_RESOURCE_PERMISSION
(
  id             NUMBER(19) not null,
  permission_ids VARCHAR2(255 CHAR),
  resource_id    NUMBER(19),
  role_id        NUMBER(19)
)
;
alter table SYS_ROLE_RESOURCE_PERMISSION
  add primary key (ID);
alter table SYS_ROLE_RESOURCE_PERMISSION
  add constraint FK_70SBCEG3L10IISPI0S8FUFBJM foreign key (ROLE_ID)
  references SYS_ROLE (ID);

prompt
prompt Creating table SYS_USER
prompt =======================
prompt
create table SYS_USER
(
  id                  NUMBER(19) not null,
  admin               NUMBER(1),
  create_date         TIMESTAMP(6),
  deleted             NUMBER(1),
  email               VARCHAR2(255 CHAR),
  mobile_phone_number VARCHAR2(255 CHAR),
  password            VARCHAR2(255 CHAR),
  salt                VARCHAR2(255 CHAR),
  status              VARCHAR2(255 CHAR),
  username            VARCHAR2(255 CHAR)
)
;
alter table SYS_USER
  add primary key (ID);

prompt
prompt Creating table SYS_USER_LAST_ONLINE
prompt ===================================
prompt
create table SYS_USER_LAST_ONLINE
(
  id                   NUMBER(19) not null,
  host                 VARCHAR2(255 CHAR),
  last_login_timestamp TIMESTAMP(6),
  last_stop_timestamp  TIMESTAMP(6),
  login_count          NUMBER(10),
  system_host          VARCHAR2(255 CHAR),
  total_online_time    NUMBER(19),
  uuid                 VARCHAR2(255 CHAR),
  user_agent           VARCHAR2(255 CHAR),
  user_id              NUMBER(19),
  username             VARCHAR2(255 CHAR)
)
;
alter table SYS_USER_LAST_ONLINE
  add primary key (ID);

prompt
prompt Creating table SYS_USER_ONLINE
prompt ==============================
prompt
create table SYS_USER_ONLINE
(
  id               VARCHAR2(255 CHAR) not null,
  host             VARCHAR2(255 CHAR),
  last_access_time TIMESTAMP(6),
  start_timestsamp TIMESTAMP(6),
  status           VARCHAR2(255 CHAR),
  system_host      VARCHAR2(255 CHAR),
  timeout          NUMBER(19),
  user_agent       VARCHAR2(255 CHAR),
  user_id          NUMBER(19),
  username         VARCHAR2(255 CHAR),
  sessionid        CLOB
)
;
alter table SYS_USER_ONLINE
  add primary key (ID);

prompt
prompt Creating table SYS_USER_ORGANIZATION_JOB
prompt ========================================
prompt
create table SYS_USER_ORGANIZATION_JOB
(
  id              NUMBER(19) not null,
  job_id          NUMBER(19),
  organization_id NUMBER(19),
  user_id         NUMBER(19)
)
;
alter table SYS_USER_ORGANIZATION_JOB
  add primary key (ID);
alter table SYS_USER_ORGANIZATION_JOB
  add constraint FK_1OELCUOW0YD17LATWUQ1TAN1P foreign key (USER_ID)
  references SYS_USER (ID);

prompt
prompt Creating table SYS_USER_STATUS_HISTORY
prompt ======================================
prompt
create table SYS_USER_STATUS_HISTORY
(
  id         NUMBER(19) not null,
  op_date    TIMESTAMP(6),
  reason     VARCHAR2(255 CHAR),
  status     VARCHAR2(255 CHAR),
  op_user_id NUMBER(19),
  user_id    NUMBER(19)
)
;
alter table SYS_USER_STATUS_HISTORY
  add primary key (ID);
alter table SYS_USER_STATUS_HISTORY
  add constraint FK_EH9TV5POEA7PCXMP6BKD4IA9L foreign key (USER_ID)
  references SYS_USER (ID);
alter table SYS_USER_STATUS_HISTORY
  add constraint FK_HD275BD1JNSULKHTQ8AR4V3W3 foreign key (OP_USER_ID)
  references SYS_USER (ID);

prompt
prompt Creating sequence COMMON_SEQ
prompt ============================
prompt
create sequence COMMON_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;


spool off
