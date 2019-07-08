package chapter1;

import com.samsung.mes4.base.ConfigConstants;
import com.samsung.mes4.base.Constants;
import com.samsung.mes4.base.util.BaseUtil;
import com.samsung.mes4.base.vo.StringDVO;
import com.samsung.mes4.sm.cmm.vo.PrivateClauseSVO;

public class PrivateClauseBiz
{
    private enum LANG_CODE
    {
        LANGCODE_KOREAN("K", ConfigConstants.MES4_PRIVACY_TEMPL_KO),
    LANGCODE_ENGLISH("E", ConfigConstants.MES4_PRIVACY_TEMPL_EN),
    LANGCODE_CHINA("C", ConfigConstants.MES4_PRIVACY_TEMPL_CHINA);

        LANG_CODE( String langCode, String docId )
        {
            this.langCode = langCode;
            this.docId = docId;
            
            if(langCode.equals("E" )) {
                String fctList = BaseUtil.getCommProperty( "privacy.euro.fct", "" );
                if ( BaseUtil.isNotEmpty( fctList ) )
                {
                    if ( fctList.indexOf( BaseUtil.getFctCode( ) ) > 0 )
                    { //포함된 법인이면 EURO로 전환
                        this.docId = ConfigConstants.MES4_PRIVACY_TEMPL_EURO;
                    }
                } 
            }
            
        }

        static LANG_CODE getType( String a )
        {
            LANG_CODE[ ] array = LANG_CODE.values( );
            for ( int i = 0; i < array.length; i++ )
            {
                if ( array[ i ].langCode == a )
                    return array[ i ];
            }
            return LANGCODE_ENGLISH;
        }

        String getDocId( )
        {
           
            return docId;
        }

        String langCode;

        String docId;

    }

    public PrivateClauseSVO getPrivateContents( PrivateClauseSVO svo ) throws Exception
    {

        //로그인 전 로직으로 변경했기 때문에 언어설정만 비교하여 보여준다
        
        //svo.getLangDVO( ).getValue( ) K E O,,,,,,,,,,,,,,,,,,,,,
        String docId = LANG_CODE.getType( svo.getLangDVO( ).getValue( ) ).getDocId( );
        
        String contents = BaseUtil.getTemplate( docId );
        StringDVO dvo = new StringDVO( );
        dvo.setValue( contents );
        svo.setContents( dvo );
        return svo;
    }
}
