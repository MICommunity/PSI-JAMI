/**
 * Copyright 2008 The European Bioinformatics Institute, and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package psidev.psi.mi.jami.bridges.unisave;

/**
 * Fasta sequence
 *

 */
public class FastaSequence {
    private String header;
    private String sequence;

    /**
     * <p>Constructor for FastaSequence.</p>
     *
     * @param header a {@link java.lang.String} object.
     * @param sequence a {@link java.lang.String} object.
     */
    public FastaSequence( String header, String sequence ) {
        this.header = header;
        this.sequence = sequence;
    }

    /**
     * <p>Getter for the field <code>header</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getHeader() {
        return header;
    }

    /**
     * <p>Getter for the field <code>sequence</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSequence() {
        return sequence;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append( ">" ).append(header).append( '\n' );
        sb.append( sequence );
        return sb.toString();
    }
}
