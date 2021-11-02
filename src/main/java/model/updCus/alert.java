package model.updCus;

import lombok.Data;

@Data
public class alert {
    private int standard;
    private int average;
    private int previous;
    private int median;
}
