package org.test.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 魏海球
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    String name;
    String subject;
    Integer score;
}
