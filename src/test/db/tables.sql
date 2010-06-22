create table tb_received_message(
	id number not null,
	link_id varchar2(50),
	san varchar2(50),
	message varchar2(200),
	sender_address varchar2(50),
	sms_serv_act_num varchar2(50),
	received_time date
);

create table TB_SCHEDULES(
	ID number not null,
	HOST_TEAM varchar2(20),
	VISITING_TEAM varchar2(20),
	PLAY_TIME date
);

create table TB_PRIZE_POOL(
	ID number not null,
	ACC_NUM varchar2(50),
	PRIZE_TYPE number,
	PRIZE_TIME date,
	IS_DRAW number
);

create sequence seq_receivedMessage
minvalue 100
maxvalue 999999999999999999999999999
start with 100 
increment by 1
cache 20;

alter table tb_received_message
  add constraint PK_received_message primary key (ID)
  using index;

alter table tb_schedules
  add constraint pk_schedules primary key(ID)
  using index;

alter table TB_PRIZE_POOL
  add constraint pk_prize_pool primary key(ID)
  using index;


