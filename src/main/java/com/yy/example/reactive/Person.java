package com.yy.example.reactive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-01-07 at 17:34
 */
@Slf4j
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private Integer id;
    private String name;
}
