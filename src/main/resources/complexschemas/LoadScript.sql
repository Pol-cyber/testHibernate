ALTER TABLE message ADD CONSTRAINT message_correctText  CHECK (text LIKE '%:%');
