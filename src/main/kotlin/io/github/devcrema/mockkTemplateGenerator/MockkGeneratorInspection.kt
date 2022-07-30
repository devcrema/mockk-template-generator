package io.github.devcrema.mockkTemplateGenerator

import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.openapi.project.Project
import org.jetbrains.kotlin.idea.inspections.AbstractKotlinInspection
import org.jetbrains.kotlin.nj2k.postProcessing.type
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.classVisitor

class MockkGeneratorInspection : AbstractKotlinInspection() {

    override fun buildVisitor(
        holder: ProblemsHolder,
        isOnTheFly: Boolean
    ) = classVisitor(fun(element: KtClass) {
        println(element.primaryConstructorParameters.map { ClassParameter(it.name!!, it.type()!!) })
        holder.registerProblem(element, "Test!!", TestFix("test!"))
    })

    class TestFix(
        private val description: String,
    ) : LocalQuickFix {
        override fun getFamilyName(): String {
            return description
        }

        override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
            println("apply fix $description")
        }

    }

}