package io.github.devcrema.mockkTemplateGenerator

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class SampleAction: AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "메시지",
            "제목",
            Messages.getInformationIcon());
    }
}