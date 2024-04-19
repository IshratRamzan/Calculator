package com.example.myapplication2
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication2.ui.theme.MyApplication2Theme
import java.text.DecimalFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication2Theme {
                // A surface container using the 'background' color from the theme
                    Greeting()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    val sky = Color(0XFFFF8A65)
    val pink = Color(0XFFEEEEEE)
    var text by remember { mutableStateOf("") }
    val firstOperand = remember { mutableStateOf("") }
    val secondOperand = remember { mutableStateOf("") }
    val operator = remember { mutableStateOf("") }
    val previousOperator = remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var final by remember { mutableStateOf("") }
    var previousResult by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Simple Calculator", fontSize = 30.sp, fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                },

                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = sky
                )
            )
        })

    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(color = Color.White), verticalArrangement = Arrangement.Bottom
        )

        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            )
            {
                Button(modifier = Modifier
                    .size(width = 130.dp, height = 80.dp)
                    .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = pink
                    ),
                    onClick = {
                        text = ""
                        firstOperand.value = ""
                        operator.value = ""
                        secondOperand.value = ""
                        result = ""
                        final = ""
                        previousResult = ""
                        previousOperator.value = ""
                    })
                {
                    Text(
                        text = "AC",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black,
                        maxLines = 2
                    )

                }
                Button(modifier = Modifier
                    .size(width = 140.dp, height = 80.dp)
                    .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = pink
                    ),
                    onClick = {
                        text = text.dropLast(1)
                        final = ""
                        previousResult = firstOperand.value
                        secondOperand.value = ""
                        operator.value = ""
                    }
                )
                {
                    Text(
                        text = "Del",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black,
                        maxLines = 2
                    )

                }
                Button(modifier = Modifier
                    .size(width = 100.dp, height = 80.dp)
                    .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = sky
                    ),
                    onClick = {
                        if (text.isNotEmpty()) {
                            if (text.isNotEmpty() && text.last().isDigit().not()) {
                                text = text.dropLast(1)
                            }
                            if (text.isNotEmpty()){
                                final = calculateExpression(text)
                                text += "/"
                                operator.value = "/"
                            }

                        }

                    }
                ) {
                    Text(
                        text = "/",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black,
                        maxLines = 2
                    )

                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            )
            {
                Button(modifier = Modifier
                    .size(width = 95.dp, height = 80.dp)
                    .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = pink
                    ),
                    onClick = {
                            text += "7"
                    })
                {
                    Text(
                        text = "7",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black,
                        maxLines = 2
                    )

                }
                Button(modifier = Modifier
                    .size(width = 95.dp, height = 80.dp)
                    .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = pink
                    ),
                    onClick = {
                        text += "8"
                    })
                {
                    Text(
                        text = "8",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black,
                        maxLines = 2
                    )

                }
                Button(modifier = Modifier
                    .size(width = 95.dp, height = 80.dp)
                    .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = pink
                    ),
                    onClick = {
                        text += "9"
                    }) {
                    Text(
                        text = "9",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black,
                        maxLines = 2
                    )

                }
                Button(modifier = Modifier
                    .size(width = 95.dp, height = 80.dp)
                    .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = sky
                    ),
                    onClick = {
                        if (text.isNotEmpty()) {
                            if (text.isNotEmpty() && text.last().isDigit().not()) {
                                text = text.dropLast(1)
                            }

                            if (text.isNotEmpty()) {
                                final = calculateExpression(text)
                                text += "*"
                                operator.value = "*"
                            }
                        }

                    }) {
                    Text(
                        text = "*",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black,
                        maxLines = 2
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            )
            {
                Button(modifier = Modifier
                    .size(width = 95.dp, height = 80.dp)
                    .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = pink
                    ),
                    onClick = {
                        text += "4"
                    }) {
                    Text(
                        text = "4",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black,
                        maxLines = 2
                    )

                }
                Button(modifier = Modifier
                    .size(width = 95.dp, height = 80.dp)
                    .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = pink
                    ),
                    onClick = {
                        text += "5"
                    }) {
                    Text(
                        text = "5",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black,
                        maxLines = 2
                    )

                }
                Button(modifier = Modifier
                    .size(width = 95.dp, height = 80.dp)
                    .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = pink
                    ),
                    onClick = {
                        text += "6"
                    }) {
                    Text(
                        text = "6",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black,
                        maxLines = 2
                    )

                }
                Button(modifier = Modifier
                    .size(width = 95.dp, height = 80.dp)
                    .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = sky
                    ),
                    onClick = {
                        if (text.isNotEmpty() && text.last().isDigit().not()) {
                            text = text.dropLast(1)
                        }

                        if (text.length > 1) {
                            final = calculateExpression(text)
                        }

                        text += "-"

                        operator.value = "-"
                    })
                {
                    Text(
                        text = "-",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black,
                        maxLines = 2
                    )

                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            )
            {
                Button(modifier = Modifier
                    .size(width = 95.dp, height = 80.dp)
                    .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = pink
                    ),
                    onClick = {
                        text += "1"
                    }) {
                    Text(
                        text = "1",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black,
                        maxLines = 2
                    )
                }
                Button(modifier = Modifier
                    .size(width = 95.dp, height = 80.dp)
                    .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = pink
                    ),
                    onClick = {
                        text += 2
                    }) {
                    Text(
                        text = "2",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black,
                        maxLines = 2
                    )
                }
                Button(modifier = Modifier
                    .size(width = 95.dp, height = 80.dp)
                    .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = pink
                    ),
                    onClick = {
                        text += "3"
                    }) {
                    Text(
                        text = "3",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black,
                        maxLines = 2
                    )
                }
                Button(modifier = Modifier
                    .size(width = 95.dp, height = 80.dp)
                    .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = sky
                    ),
                    onClick = {
                        if (text.isNotEmpty() && text.last().isDigit().not()) {
                            text = text.dropLast(1)
                        }

                        if (text.length > 1) {
                            final = calculateExpression(text)
                        }

                        text += "+"

                        operator.value = "+"
                    })
                {
                    Text(
                        text = "+",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black,
                        maxLines = 2
                    )

                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            )
            {
                Button(modifier = Modifier
                    .size(width = 140.dp, height = 80.dp)
                    .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = pink
                    ),
                    onClick = {
                        text += "0"
                    }) {
                    Text(
                        text = "0",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black,
                        maxLines = 2
                    )

                }
                Button(modifier = Modifier
                    .size(width = 130.dp, height = 80.dp)
                    .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = pink
                    ),
                    onClick = {
                        if (text.isNotEmpty()) {
                            text += "."
                        }
                    }
                ) {
                    Text(
                        text = ".",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black,
                        maxLines = 2
                    )
                }
                Button(
                    modifier = Modifier
                        .size(width = 100.dp, height = 80.dp)
                        .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = sky
                    ),
                    onClick = {

                            if(text.isNotEmpty()) {
                                text = calculateExpression(text)
                            }

                            final = ""

                        } )
                    {
                    Text(
                        text = "=",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black,
                        maxLines = 2
                    )
                }
            }
        }
    }

//Input String
    Text(
        text = if (text.length < 14) {
            text
        } else {
            text.substring(0, 14)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 10.dp, top = 150.dp),
        color = Color.Black,
        fontSize = 45.sp,
        textAlign = TextAlign.Right,
        maxLines = 1,
    )

    // Result
    Text(
        text = if (final.length < 12) {
            final
        } else {
            final.substring(0, 12)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 10.dp, top = 220.dp),
        color = Color.Black,
        fontSize = 35.sp,
        textAlign = TextAlign.Right,
        maxLines = 1,
    )
}

    //Perform Operation

fun performOperation(firstOperand: Double, operator: String, secondOperand: Double): Double {
    return when (operator) {
        "+" -> firstOperand + secondOperand
        "-" -> firstOperand - secondOperand
        "*" -> firstOperand * secondOperand
        "/" -> firstOperand / secondOperand
        else -> throw IllegalArgumentException("Invalid operator: $operator")
    }
}

    //Perform Calculate Expression

fun calculateExpression(text: String): String {
    val expression = text.replace(" ", "")
    val tokens = mutableListOf<String>()
    val num = StringBuilder()

    // Split the expression into tokens (numbers and operators)

    for (char in expression) {
        if (char.isDigit() || char == '.') {
            num.append(char)
        } else {
            if (num.isNotEmpty()) {
                tokens.add(num.toString())
                num.clear()
            }
            tokens.add(char.toString())
        }
    }
    if (num.isNotEmpty()) {
        tokens.add(num.toString())
    }

    // Handle negative numbers

    var i = 0
    while (i < tokens.size) {
        if (tokens[i] == "-" && (i == 0 || tokens[i - 1] in "+-*/")) {
            if (i < tokens.size - 1 && tokens[i + 1].isNumeric()) {
                tokens[i] += tokens[i + 1]
                tokens.removeAt(i + 1)
            }
        }
        i++
    }

// Handle positive numbers

    i = 0
    while (i < tokens.size) {
        if (tokens[i] == "+" && (i == 0 || tokens[i - 1] in "+-*/")) {
            if (i < tokens.size - 1 && tokens[i + 1].isNumeric()) {
                tokens[i] += tokens[i + 1]
                tokens.removeAt(i + 1)
            }
        }
        i++
    }

    if (tokens.lastOrNull()?.isNumeric() == false) {
        tokens.removeLast()
    }


    // Multiply & Div

    val interResult = mutableListOf<String>()
    i = 0
    while (i < tokens.size) {
        val token = tokens[i]
        if (token == "*" || token == "/") {
            val firstOperand = interResult.removeAt(interResult.size - 1).toDouble()
            val secondOperand = tokens[i + 1].toDouble()
            interResult.add(performOperation(firstOperand, token, secondOperand).toString())
            i++
        } else {
            interResult.add(token)
        }
        i++
    }

    //Add & Sub

    var result=interResult[0].toDouble()
    i=1
    while(i<interResult.size){
        val operator=interResult[i]
        val operand=interResult[i+1].toDouble()
        result= performOperation(result,operator,operand)
        i+=2
    }
    val decimalFormat = DecimalFormat("#.########")
    return decimalFormat.format(result)
}

fun String.isNumeric(): Boolean {
    return try {
        this.toDouble()
        true
    } catch (e: NumberFormatException) {
        false
    }
}
