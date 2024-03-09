package com.geektrust.backend.Commands;

import java.util.List;

public interface Icommand {
    void execute(List<String> tokens);
}
