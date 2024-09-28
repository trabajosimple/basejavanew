CREATE TABLE resume (
                        uuid      CHARACTER VARYING  PRIMARY KEY NOT NULL,
                        full_name CHARACTER VARYING  NOT NULL
);

CREATE TABLE contact (
                         id          SERIAL,
                         resume_uuid CHARACTER VARYING NOT NULL REFERENCES resume (uuid) ON DELETE CASCADE,
                         type        CHARACTER VARYING     NOT NULL,
                         value       CHARACTER VARYING     NOT NULL
);
CREATE UNIQUE INDEX contact_uuid_type_index
    ON contact (resume_uuid, type);