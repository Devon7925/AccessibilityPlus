package com.luissanchezdev.accessibilityplus.gui;

import com.luissanchezdev.accessibilityplus.NarratorPlus;

import io.github.cottonmc.cotton.gui.GuiDescription;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;

public class ConfigScreen extends CottonClientScreen {
    private WWidget spokenElement;

    public ConfigScreen(GuiDescription description) {
        super(new TranslatableText("gui.accessibilityplus.config.title"), description);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float partialTicks) {
        super.render(matrices, mouseX, mouseY, partialTicks);

        WWidget focusedElement = this.description.getFocus();
        if (focusedElement == null || focusedElement == this.spokenElement) {
            return;
        }

        this.spokenElement = focusedElement;

        if (focusedElement instanceof WButton) {
            NarratorPlus.narrate(((WButton) focusedElement).getLabel().getString());
        }
    }
}