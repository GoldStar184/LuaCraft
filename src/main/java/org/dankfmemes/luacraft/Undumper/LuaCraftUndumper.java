package org.dankfmemes.luacraft.Undumper;

import org.luaj.vm2.Globals;
import org.luaj.vm2.Prototype;

import java.io.IOException;
import java.io.InputStream;

public class LuaCraftUndumper implements Globals.Undumper {
    private Globals globals = null;

    public LuaCraftUndumper(Globals globals) {
        this.globals = globals;
    }

    @Override
    public Prototype undump(InputStream inputStream, String name) throws IOException {
        if (globals.compiler == null) {
            throw new IOException("No compiler available in Globals.");
        }

        return globals.compiler.compile(inputStream, name);
    }
}