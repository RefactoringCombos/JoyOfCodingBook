const assert = require('assert');
const lambda = require('../src/Lambda');
require('approvals').mocha();

describe('Lambda', () => {
    it('test with straight mocha',function()  {
        assert.equal(25, new lambda.Lambda().a());
        assert.equal(25, new lambda.Lambda().b());
        assert.equal(25, new lambda.Lambda().c());

    });

});