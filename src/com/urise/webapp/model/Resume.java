package com.urise.webapp.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Resume implements Comparable<Resume> {
  private final String uuid;
  private final String fullName;
  private final Map<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);
  private final Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);

  public Resume(String fullName) {
    this(UUID.randomUUID().toString(), fullName);
  }

  public Resume(String uuid, String fullName) {
    Objects.requireNonNull(uuid, "uuid must not be null");
    Objects.requireNonNull(fullName, "fullName must not be null");
    this.uuid = uuid;
    this.fullName = fullName;
  }

  public Resume(Resume r) {
    this.uuid = r.uuid;
    this.fullName = r.fullName;
  }

  public String getUuid() {
    return uuid;
  }

  public AbstractSection getSection(SectionType sectionType) {
    return sections.get(sectionType);
  }

  public String getContact(ContactType contactType) {
    return contacts.get(contactType);
  }

  public void setContact(ContactType type, String value) {
    contacts.put(type, value);
  }

  public void setSection(SectionType type, AbstractSection section) {
    sections.put(type, section);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Resume resume = (Resume) o;
    return uuid.equals(resume.uuid) && fullName.equals(resume.fullName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, fullName);
  }

  @Override
  public String toString() {
    return "Resume{" +
            "uuid='" + uuid + '\'' +
            ", fullName='" + fullName + '\'' +
            ",\n sections=" + sections +
            ",\n contacts=" + contacts +
            '}';
  }

  @Override
  public int compareTo(Resume o) {
    int cmp = fullName.compareTo(o.fullName);
    return cmp != 0 ? cmp : uuid.compareTo(o.uuid);
  }
}
