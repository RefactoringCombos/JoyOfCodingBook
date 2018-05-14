#include "ApprovalTests.hpp"
#include "Catch.hpp"
#include "../code/YourCodeGoesHere.h"
/**
 * In clion, you can run this with ctrl+r
 * You might need to add a Catch Runtime to see it in the unit test window
 * Run > edit configurations > + > Catch > Target=Playground_Tests
 */
TEST_CASE("lambdas")
{
    REQUIRE("25 25 25 " == introduce_lambda());
}



