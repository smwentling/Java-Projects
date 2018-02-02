/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package score;

import index.Index;

/**
 *
 * @author Matthew Kwan, matthewky.kwan@gmail.com
 */
public class TFIDFScoringFun implements TermScoringFun {
    
    private Index _index;

    @Override
    public void init(Index s) {
        _index = s;
    }

    @Override
    public double scoreToken(String term, int freq) {
        return Math.log10(1.0+(double)freq) * Math.log10((double)_index.getDocSource().getNumDocs() / (double)_index.getDocumentFreq(term));
    }
    
}
