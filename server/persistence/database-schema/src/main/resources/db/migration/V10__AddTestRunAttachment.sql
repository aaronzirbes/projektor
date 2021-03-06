CREATE TABLE test_run_attachment(
   id          bigserial primary key,
   test_run_id bigint references test_run ON DELETE CASCADE,
   file_name   text NOT NULL,
   object_name text NOT NULL,
   file_size   bigint
);

ALTER TABLE test_run ADD COLUMN has_attachments boolean NOT NULL DEFAULT false;
