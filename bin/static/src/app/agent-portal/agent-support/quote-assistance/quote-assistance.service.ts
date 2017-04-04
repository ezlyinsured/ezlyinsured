import { Injectable } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { TypedJSON } from 'typedjson-npm/src/typed-json';

//IMP dependencies
import { ProductVariableData } from '../../shared/model/configuration/product-variable-data';
import { ProductCoverage } from '../../shared/model/configuration/product-coverage';
import { Policy } from '../../shared/model/core/policy';
import { Risk } from '../../shared/model/core/risk';
import { PolicySummary } from '../../shared/model/core/policy-summary';

/**
 * Quote service.
 * @author ccasallas
 *
*/
@Injectable()
export class QuoteAssistanceService {

    policyToQuote: Policy; //singleton
    
    constructor( private http: Http ) { }
    
    /**
     * Service used for quick quote component to define policy to
     * be quoted at initialization of quote component
     */
    setPolicyToQuote(policy:Policy): void {
        this.policyToQuote = policy;        
    }
    
    /**
     * Service used quote component to trigger quick quote on component
     * initialization
     */
    getPolicyToQuote(): Policy {  
        return this.policyToQuote;
    }
    
    /**
     * call the quick quote process to retrieve the set of policies 
     */
    callQuickQuote( policy: Policy ): Promise<PolicySummary[]> {
        return this.http.post( 'http://localhost:8080/processQuickQuoteSummary', policy ).toPromise()
            .then( response =>
                response.json() as PolicySummary[]
            )
            .catch( this.handleError );
    }
    
    /**
     * Get product variable data by productId
     */
    getProductVariableData( productId: string ): Promise<ProductVariableData> {
        return this.http.get( 'http://localhost:8080/product/'+ productId +'/variable-data').toPromise()
            .then( response =>
                TypedJSON.parse( response.json(), ProductVariableData )
            )
            .catch( this.handleError );
    }
    
    /**
     * Get product coverage by productId
     */
    getCoveragePolicyLevel( productId: string ): Promise<ProductCoverage> {
        return this.http.get( 'http://localhost:8080/product/'+ productId +'/coverage-policy-level').toPromise()
            .then( response =>
                TypedJSON.parse( response.json(), ProductCoverage )
            )
            .catch( this.handleError );
    }

    /**
     * Get product coverage by productId
     */
    getCoverageRiskLevel( productId: string ): Promise<ProductCoverage> {
        return this.http.get( 'http://localhost:8080/product/'+ productId +'/coverage-risk-level').toPromise()
            .then( response =>
                TypedJSON.parse( response.json(), ProductCoverage )
            )
            .catch( this.handleError );
    }
    
    private handleError( error: any ): Promise<any> {
        return Promise.reject( error.message || error );
    }

}