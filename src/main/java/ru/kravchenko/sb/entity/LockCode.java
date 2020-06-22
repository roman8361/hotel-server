package ru.kravchenko.sb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "DICT_LOCK_CODE")
public class LockCode extends AbstractEntity {

    private String lockCode;

    private String roomNumber;

}
